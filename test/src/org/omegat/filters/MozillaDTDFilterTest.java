/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2011 Alex Buloichik
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

package org.omegat.filters;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.omegat.core.data.IProject;
import org.omegat.filters2.IAlignCallback;
import org.omegat.filters2.IFilter;
import org.omegat.filters2.mozdtd.MozillaDTDFilter;

public class MozillaDTDFilterTest extends TestFilterBase {
    @Test
    public void testLoad() throws Exception {
        String f = "test/data/filters/MozillaDTD/file.dtd";
        IProject.FileInfo fi = loadSourceFiles(new MozillaDTDFilter(), f);

        checkMultiStart(fi, f);
        checkMulti("Title", "mainWindow.title", null, null, null, null);
        checkMulti("File", "fileMenu.label", null, null, null, null);
        checkMulti("Edit", "editMenu.label", null, null, null, null);
        checkMultiEnd();
    }

    @Test
    public void testTranslate() throws Exception {
        translateText(new MozillaDTDFilter(), "test/data/filters/MozillaDTD/file.dtd");
    }

    public static class AlignResult {
        boolean found = false;
    }

    @Test
    public void testAlign() throws Exception {
        final AlignResult ar = new AlignResult();
        align(new MozillaDTDFilter(), "MozillaDTD/file.dtd",
                "MozillaDTD/file-be.dtd",
                new IAlignCallback() {
                    @Override
                    public void addTranslation(final String id, final String source, final String translation, final boolean isFuzzy, final String path, final IFilter filter) {
                        ar.found |= id.equals("mainWindow.title") && source.equals("Title") && translation.equals("Title-be");
                    }
                });
        assertTrue(ar.found);
    }
}
