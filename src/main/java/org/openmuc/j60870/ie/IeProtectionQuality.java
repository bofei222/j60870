/*
 * Copyright 2014-2022 Fraunhofer ISE
 *
 * This file is part of j60870.
 * For more information visit http://www.openmuc.org
 *
 * j60870 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * j60870 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with j60870.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openmuc.j60870.ie;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Represents a quality descriptor for events of protection equipment (QDP) information element.
 */
public class IeProtectionQuality extends IeAbstractQuality {

    public IeProtectionQuality(boolean elapsedTimeInvalid, boolean blocked, boolean substituted, boolean notTopical,
                               boolean invalid) {
        super(blocked, substituted, notTopical, invalid);

        if (elapsedTimeInvalid) {
            value |= 0x08;
        }
    }

    IeProtectionQuality(DataInputStream is) throws IOException {
        super(is);
    }

    public boolean isElapsedTimeInvalid() {
        return (value & 0x08) == 0x08;
    }

    @Override
    public String toString() {
        return "Protection Quality, elapsed time invalid: " + isElapsedTimeInvalid() + ", " + super.toString();
    }
}
