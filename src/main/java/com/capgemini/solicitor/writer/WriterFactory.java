/**
 * Copyright 2019 Capgemini SE.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.capgemini.solicitor.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.solicitor.SolicitorRuntimeException;

@Component
public class WriterFactory {

    @Autowired
    private Writer[] writers;

    public Writer writerFor(String type) {

        for (Writer writer : writers) {
            if (writer.accept(type)) {
                return writer;
            }
        }
        throw new SolicitorRuntimeException(
                "No Writer defined for type '" + type + "'");
    }

}
