package org.example;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import jakarta.inject.Inject;
import jakarta.inject.Named;
//import com.google.inject.Inject;
//import com.google.inject.name.Named;
import com.google.inject.name.Names;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TextEditorModule());
        TextEditor editor = injector.getInstance(TextEditor.class);
        editor.print();
    }

    interface SpellChecker {
        void check(String input);
    }

    static class GoogleSpellChecker implements SpellChecker {

        @Override
        public void check(String input) {

        }
    }

    static class TextEditor {
        private SpellChecker checker;

        @Inject
        public TextEditor(@Named("defaultSpellChecker") SpellChecker checker) {
            this.checker = checker;
        }

        public void print() {
            if (checker != null) {
                System.out.println("Checker is initialized");
            }
        }
    }

    static class TextEditorModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(SpellChecker.class).annotatedWith(Names.named("defaultSpellChecker")).to(GoogleSpellChecker.class);
        }

    }
}