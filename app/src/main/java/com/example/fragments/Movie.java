package com.example.fragments;

/**
 * Helper class for the dummy data class "Arnold.java".
 */

    public class Movie {
        private String title;
        private int productionYear;
        private String description;
        private String director;

        public Movie(String title, int productionYear, String description, String director) {
            this.title = title;
            this.productionYear = productionYear;
            this.description = description;
            this.director = director;
        }

        public String getTitle() {
            return title;
        }

        public String getProductionYearAsString() {
            return productionYear + "";
        }

        public String getDescription() {
            return description;
        }

        public String getDirector() {
            return director;
        }

        public String getMovieDescription(){
            String description = "";
            description += "Title: " + getTitle() + getLinebreak();
            description += "Production Year: " + getProductionYearAsString() + getLinebreak();
            description += "Description: " + getDescription() + getLinebreak();
            description += "Director: " +getDirector();

            return description;
        }

        private String getLinebreak(){
            return "\n \n";
        }
    }
