package org.givwenzen.text.matching.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.givwenzen.MethodAndInvocationTarget;
import org.givwenzen.text.matching.Similarity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.lucene.document.Field.Index.ANALYZED;
import static org.apache.lucene.document.Field.Store.YES;
import static org.apache.lucene.index.IndexWriter.MaxFieldLength.LIMITED;
import static org.apache.lucene.util.Version.LUCENE_30;

public class LuceneSimilarity implements Similarity {

   StandardAnalyzer analyzer = new StandardAnalyzer(LUCENE_30);
   String contentFieldName = "contents";

   @Override
   public Collection<String> findSimilarMethods(String methodString, Collection<MethodAndInvocationTarget> steps) {
      Collection<String> methodAnnotations = new ArrayList<String>();
      try {
         Directory indexDir = buildLuceneIndexFrom(steps);
         IndexReader reader = IndexReader.open(indexDir, true);
         final Searcher searcher = new IndexSearcher(reader);
         ScoreDoc[] methods = findSimilarMethods(methodString, indexDir, new IndexSearcher(reader));
         methodAnnotations = translateToMethodAnnotationStrings(methods, searcher);
      } catch (IOException e) {
         // using an in memory directory and not doing IO, problem with lucene interface
         e.printStackTrace();
      }
      return methodAnnotations;
   }

   private Collection<String> translateToMethodAnnotationStrings(ScoreDoc[] methods, Searcher searcher) {
      List<String> methodAnnotations = new ArrayList<String>();
      try {
         for (ScoreDoc method : methods) {
            methodAnnotations.add(searcher.doc(method.doc).get(contentFieldName));
         }
      } catch (IOException e) {
         // using an in memory directory and not doing IO, problem with lucene interface
         e.printStackTrace();
      }
      return methodAnnotations;
   }

   private ScoreDoc[] findSimilarMethods(String methodString, Directory indexDir, Searcher searcher) {
      ScoreDoc[] hits = new ScoreDoc[0];
      try {
         QueryParser parser = new QueryParser(LUCENE_30, contentFieldName, analyzer);
         Query query = parser.parse(methodString);
         TopScoreDocCollector collector = TopScoreDocCollector.create(5, true);
         searcher.search(query, collector);
         hits = collector.topDocs().scoreDocs;
      } catch (Exception e) {
         // using an in memory directory and not doing IO, problem with lucene interface
         e.printStackTrace();
      }
      return hits;
   }

   private Directory buildLuceneIndexFrom(Collection<MethodAndInvocationTarget> steps) {
      final Directory indexDir = new RAMDirectory();
      try {
         IndexWriter writer = new IndexWriter(indexDir, analyzer, true, LIMITED);
         for (MethodAndInvocationTarget step : steps) {
            Document documentA = new Document();
            documentA.add(new Field(contentFieldName, step.getDomainStepPattern(), YES, ANALYZED));
            writer.addDocument(documentA);
         }
         writer.optimize();
         writer.close();
      } catch (Exception e) {
         // using an in memory directory and not doing IO, problem with lucene interface
         e.printStackTrace();
      }

      return indexDir;
   }
}
