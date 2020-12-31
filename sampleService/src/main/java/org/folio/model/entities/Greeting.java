package org.folio.model.entities;

public class Greeting {

    private String greeting;

    private String language;

    public Greeting(String greeting, String language) {
        this.greeting = greeting;
        this.language = language;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
