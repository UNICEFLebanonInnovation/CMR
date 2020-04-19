package com.accessibilities.CMRAPP;

class Cell {

    public static final int TEXT_TYPE = 0;
    public static final int YESNO_TYPE = 1;
    public static final int HINT_TYPE = 2;
    public static final int TITLE_TYPE = 3;
    public static final int PDF_TYPE = 4;

    int type;
    int id;
    String title;
    String subtitle;
    String hint;
    String yesButton;
    String noButton;
    String nextScreen;


    // Title
    Cell(int type, String title, int id, String nextScreen) {
        this.type = type;
        this.title = title;
        this.id = id;
        this.nextScreen = nextScreen;
    }

    // Title + Subtitle
    Cell(int type, String title, String subtitle) {
        this.type = type;
        this.title = title;
        this.subtitle = subtitle;
    }

    // Yes - No
    Cell(int type, String title, String subtitle, String yesButton, String noButton) {
        this.title = title;
        this.subtitle = subtitle;
        this.type = type;
        this.yesButton = yesButton;
        this.noButton = noButton;
    }

    // Hint
    Cell(int type, String title, String subtitle, String hint) {
        this.type=type;
        this.title = title;
        this.subtitle = subtitle;
        this.hint = hint;
    }

}