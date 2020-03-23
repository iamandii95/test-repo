package com.company;

    public class CatalogSingletone {
        private static Catalog instance;

        public static Catalog getInstance() {
            if(instance != null) {
                return instance;
            }

            instance =  new Catalog();
            return instance;
        }

        public static void setInstance(Catalog catalog) {
            instance = catalog;
        }
    }
