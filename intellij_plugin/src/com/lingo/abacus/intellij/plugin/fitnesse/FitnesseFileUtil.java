package com.lingo.abacus.intellij.plugin.fitnesse;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileFilter;
import com.intellij.openapi.vfs.impl.local.LocalFileSystemImpl;
import com.intellij.openapi.vfs.newvfs.ManagingFS;
import com.intellij.util.PathsList;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 27-Oct-2006 17:13:30
 */
public class FitnesseFileUtil {
    public static final VirtualFileFilter JAR_ZIP_FILTER = new JarZipFileFilter();
    public static final VirtualFileFilter FITNESSE_JAR_FILTER = new FitnesseJarFilter();

    public static void addClathPath(PathsList classPath, VirtualFile libPath,
                              VirtualFileFilter fileFilter) {
        if (libPath != null && libPath.isDirectory()) {
            VirtualFile[] files = libPath.getChildren();
            for (VirtualFile file : files) {

                if (file.isDirectory()) {
                    addClathPath(classPath, file, fileFilter);
                } else if (fileFilter.accept(file)) {
                    classPath.add(file.getPath());
                }
            }
        }
        
    }

    /**
     * Retreive a Virtual file from the Local file System
     * @param libPath
     * @return
     */
    public static  VirtualFile getVirtualFile(String libPath) {
        final LocalFileSystemImpl fileSystem = new LocalFileSystemImpl(ManagingFS.getInstance());
        final VirtualFile file = fileSystem.findFileByPath(libPath);
        return file;
    }
    private static class JarZipFileFilter implements VirtualFileFilter {

        public boolean accept(VirtualFile file) {
            String extention = file.getExtension();
            if (extention !=null) {
                if (extention.equalsIgnoreCase("zip") || extention.equalsIgnoreCase("jar")) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class FitnesseJarFilter implements VirtualFileFilter {

        public boolean accept(VirtualFile file) {
            if("fitnesse.jar".equalsIgnoreCase(file.getName())){
                return true;
            }
            return false;
        }
    }
}
