/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2015 Aaron Madlon-Kay
               Home page: http://www.omegat.org/
               Support center: https://omegat.org/support

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/

package org.omegat.gui.dictionaries;

import org.omegat.core.dictionaries.IDictionary;
import org.omegat.core.dictionaries.IDictionaryFactory;

public interface IDictionaries {
    /**
     * Refresh content on dictionary file changed.
     */
    void refresh();

    void addDictionaryFactory(IDictionaryFactory factory);

    void removeDictionaryFactory(IDictionaryFactory factory);

    void addDictionary(IDictionary dictionary);

    void removeDictionary(IDictionary dictionary);

    void searchText(String text);
}
