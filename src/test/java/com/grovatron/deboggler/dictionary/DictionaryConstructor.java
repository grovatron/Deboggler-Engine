package com.grovatron.deboggler.dictionary;

import java.io.InputStream;

public interface DictionaryConstructor {

	Dictionary buildDictionary(InputStream inputStream);
}
