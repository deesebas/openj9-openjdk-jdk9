/*
 * reserved comment block
 * DO NOT REMOVE OR ALTER!
 */
/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.sun.org.apache.xml.internal.security.keys.content;

import com.sun.org.apache.xml.internal.security.exceptions.XMLSecurityException;
import com.sun.org.apache.xml.internal.security.utils.Constants;
import com.sun.org.apache.xml.internal.security.utils.Signature11ElementProxy;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Provides content model support for the <code>dsig11:KeyInfoReference</code> element.
 *
 * @author Brent Putman (putmanb@georgetown.edu)
 */
public class KeyInfoReference extends Signature11ElementProxy implements KeyInfoContent {

    /**
     * Constructor RetrievalMethod
     *
     * @param element
     * @param BaseURI
     * @throws XMLSecurityException
     */
    public KeyInfoReference(Element element, String baseURI) throws XMLSecurityException {
        super(element, baseURI);
    }

    /**
     * Constructor RetrievalMethod
     *
     * @param doc
     * @param URI
     */
    public KeyInfoReference(Document doc, String URI) {
        super(doc);

        this.constructionElement.setAttributeNS(null, Constants._ATT_URI, URI);
    }

    /**
     * Method getURIAttr
     *
     * @return the URI attribute
     */
    public Attr getURIAttr() {
        return this.constructionElement.getAttributeNodeNS(null, Constants._ATT_URI);
    }

    /**
     * Method getURI
     *
     * @return URI string
     */
    public String getURI() {
        return this.getURIAttr().getNodeValue();
    }

    /**
     * Sets the <code>Id</code> attribute
     *
     * @param Id ID
     */
    public void setId(String id) {
        if (id != null) {
            this.constructionElement.setAttributeNS(null, Constants._ATT_ID, id);
            this.constructionElement.setIdAttributeNS(null, Constants._ATT_ID, true);
        } else {
            this.constructionElement.removeAttributeNS(null, Constants._ATT_ID);
        }
    }

    /**
     * Returns the <code>Id</code> attribute
     *
     * @return the <code>Id</code> attribute
     */
    public String getId() {
        return this.constructionElement.getAttributeNS(null, Constants._ATT_ID);
    }

    /** @inheritDoc */
    public String getBaseLocalName() {
        return Constants._TAG_KEYINFOREFERENCE;
    }
}
