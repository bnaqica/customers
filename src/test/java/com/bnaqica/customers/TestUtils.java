package com.bnaqica.customers;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.apache.commons.io.IOUtils.resourceToString;

public class TestUtils {

    public static String getResourceAsString(String resourceName) throws IOException {
        return resourceToString(resourceName, Charset.defaultCharset(), TestUtils.class.getClassLoader());
    }

}
