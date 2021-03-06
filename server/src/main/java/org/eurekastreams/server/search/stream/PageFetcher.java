/*
 * Copyright (c) 2009 Lockheed Martin Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eurekastreams.server.search.stream;

import java.util.List;

/**
 * Fetch a page of data.
 * 
 * @param <T>
 *            the type of data to fetch
 */
public interface PageFetcher<T>
{
    /**
     * Get the next page of data.
     * 
     * @param inStartIndex
     *            the starting index
     * @param inPageSize
     *            the page size
     * @return a list of Activity IDs
     */
    List<T> fetchPage(final int inStartIndex, final int inPageSize);
}
