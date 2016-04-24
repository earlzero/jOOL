/**
 * Copyright (c) 2014-2016, Data Geekery GmbH, contact@datageekery.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jooq.lambda.fi.util.function;

import java.util.function.Consumer;
import java.util.function.ObjDoubleConsumer;
import org.jooq.lambda.Unchecked;

/**
 * A {@link ObjDoubleConsumer} that allows for checked exceptions.
 *
 * @author Lukas Eder
 */
@FunctionalInterface
public interface CheckedObjDoubleConsumer<T> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param value the second input argument
     */
    void accept(T t, double value) throws Throwable;

    /**
     * @See {@link Unchecked#objDoubleConsumer(CheckedObjDoubleConsumer)}
     */
    static <T> ObjDoubleConsumer<T> unchecked(CheckedObjDoubleConsumer<T> consumer) {
        return Unchecked.objDoubleConsumer(consumer);
    }

    /**
     * @See {@link Unchecked#objDoubleConsumer(CheckedObjDoubleConsumer, Consumer)}
     */
    static <T> ObjDoubleConsumer<T> unchecked(CheckedObjDoubleConsumer<T> consumer, Consumer<Throwable> handler) {
        return Unchecked.objDoubleConsumer(consumer, handler);
    }
}
