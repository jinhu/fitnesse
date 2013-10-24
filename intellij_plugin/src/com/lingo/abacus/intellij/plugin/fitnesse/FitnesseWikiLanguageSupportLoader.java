package com.lingo.abacus.intellij.plugin.fitnesse;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.PlainTextFileType;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.colors.ColorSettingsPages;
import com.lingo.abacus.intellij.plugin.fitnesse.gui.FitnesseConfiguration;
import com.lingo.abacus.intellij.plugin.fitnesse.language.filetype.FitnesseFileType;
import com.lingo.abacus.intellij.plugin.fitnesse.language.filetype.FitnesseMatcher;
import com.lingo.abacus.intellij.plugin.fitnesse.language.highlighting.FitnesseColorsAndFontsPage;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Fitnesse Support Loader adds Fitnesse support to the environment. This will make *.txt files viewed as Fitnesse wiki
 * page content.
 *
 * @User: florian hehlen
 * @Date: 24-Sep-2006 15:30:46
 */
public class FitnesseWikiLanguageSupportLoader implements ApplicationComponent, Configurable, PersistentStateComponent {

    public static final LanguageFileType FITNESSE = new FitnesseFileType();

    public boolean parsingEnabled = true;
    public String homePath;
    public String rootPath;
    public String libPath;

    private FitnesseConfiguration configuration;
    private FileType defaultTxtFiletype;

    public FitnesseWikiLanguageSupportLoader() {
        final FileTypeManager mgr = FileTypeManager.getInstance();
        defaultTxtFiletype = mgr.getFileTypeByExtension("txt");
    }

    /**
     * Initialise at start up
     */
    public void initComponent() {
        setParsingEnabled(parsingEnabled);
        registerInColorPage();
    }


    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    public String getComponentName() {
        return FitnessePluginResources.getFitnessePluginName() + ":LanguageSupportLoader";
    }

    public boolean isParsingEnabled() {
        return parsingEnabled;
    }

    /**
     * Register/Unregister the file type for parsing
     *
     * @param parsingEnabled
     */
    public void setParsingEnabled(final boolean parsingEnabled) {
        this.parsingEnabled = parsingEnabled;
        final FileTypeManager typeManager = FileTypeManager.getInstance();
        if (parsingEnabled) {
            ApplicationManager.getApplication().runWriteAction(
                    new Runnable() {
                        public void run() {
                            typeManager.registerFileType(FITNESSE, FitnesseMatcher.getList());
                            //typeManager. save();
                            System.out.println("ADD SUPPORT");
                        }
                    });
        } else {

            ApplicationManager.getApplication().runWriteAction(
                    new Runnable() {
                        public void run() {
                            if (defaultTxtFiletype instanceof FitnesseFileType) {

                                typeManager.registerFileType(PlainTextFileType.INSTANCE, new String[]{"txt"});
                                System.out.println("add old support");
                            } else {
                                typeManager.registerFileType(defaultTxtFiletype, new String[]{"txt"});

                            }
                        }
                    });
        }
    }

    /**
     * Register with the Color and Font Page for configuration of Fitnesse highlighting
     */
    private void registerInColorPage() {
        ApplicationManager.getApplication().runWriteAction(
                new Runnable() {
                    public void run() {
                        //todo: parsing  to implement so as to do hints and other complexe features
                        //ChooseByNameRegistry.getInstance().contributeToSymbols(new JavaScriptSymbolContributor());
                        ColorSettingsPages instance = ColorSettingsPages.getInstance();
                        if (instance != null) {
                            instance.registerPage(new FitnesseColorsAndFontsPage());

                        }
                    }
                }

        );
    }

    /**
     * @return
     */
    @Nls
    public String getDisplayName() {
        return FitnessePluginResources.getFitnessePluginName();
    }

    /**
     * Provide the icon for display in the Settings pannel
     *
     * @return
     */
    public Icon getIcon() {
        return FitnessePluginResources.getSettingsIcon();
    }

    @Nullable
    @NonNls
    public String getHelpTopic() {
        return null;
    }

    /**
     * Returns the user interface component for editing the configuration.
     *
     * @return the component instance.
     */
    public JComponent createComponent() {
        if (configuration == null) {
            configuration = new FitnesseConfiguration();
        }
        return configuration.getRootComponent();
    }

    /**
     * Checks if the settings in the user interface component were modified by the user and need to be saved.
     *
     * @return true if the settings were modified, false otherwise.
     */
    public boolean isModified() {
        return configuration != null && configuration.isModified(this);
    }

    /**
     * Store the settings from configurable to other components.
     */
    public void apply() throws ConfigurationException {
        if (configuration != null) {
            // Get data from form to component
            configuration.getData(this);
        }
    }

    /**
     * Load settings from other components to configurable.
     */
    public void reset() {
        if (configuration != null) {
            // Reset form data from component
            configuration.setData(this);
        }
    }

    /**
     * Disposes the Swing components used for displaying the configuration.
     */
    public void disposeUIResources() {
        configuration = null;
    }



    public String getHomePath() {
        return homePath;
    }

    public void setHomePath(final String homePath) {
        this.homePath = homePath;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(final String rootPath) {
        this.rootPath = rootPath;
    }

    public String getLibPath() {
        return libPath;
    }

    public void setLibPath(final String libPath) {
        this.libPath = libPath;
    }

    @Nullable
    @Override
    public Object getState() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadState(Object o) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
