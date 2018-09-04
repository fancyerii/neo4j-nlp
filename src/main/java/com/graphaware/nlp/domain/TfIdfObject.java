/*
 * Copyright (c) 2013-2018 GraphAware
 *
 * This file is part of the GraphAware Framework.
 *
 * GraphAware Framework is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package com.graphaware.nlp.domain;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class TfIdfObject {

    private double tf;
    private double idf;

    @JsonCreator
    public TfIdfObject(@JsonProperty("tf") double tf, @JsonProperty("idf") double idf) {
        this.tf  = tf;
        this.idf = idf;
    }

    public void setTf(double tf) {
        this.tf = tf;
    }

    public void setIdf(double idf) {
        this.idf = idf;
    }

    public double getTf() {
        return this.tf;
    }

    public double getIdf() {
        return this.idf;
    }

    @JsonIgnore
    public double getTfIdf() {
        return this.tf * this.idf;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!TfIdfObject.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final TfIdfObject other = (TfIdfObject) obj;
        if ( this.tf != other.getTf() )
            return false;
        if ( this.idf != other.getIdf() )
            return false;
        return true;
    }
}
