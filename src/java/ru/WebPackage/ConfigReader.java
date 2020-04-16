package ru.WebPackage;

import java.math.BigInteger;

public class ConfigReader {
    private static BigInteger maxPrice;
    private static String organizationCodeList;
    private static int markup;

    public static BigInteger getMaxPrice() {
        return maxPrice;
    }

    public static void setMaxPrice(BigInteger maxPrice) {
        ConfigReader.maxPrice = maxPrice;
    }

    public static String getOrganizationCodeList() {
        return organizationCodeList;
    }

    public static void setOrganizationCodeList(String organizationCodeList) {
        ConfigReader.organizationCodeList = organizationCodeList;
    }

    public static int getMarkup() {
        return markup;
    }

    public static void setMarkup(int markup) {
        ConfigReader.markup = markup;
    }   
}
