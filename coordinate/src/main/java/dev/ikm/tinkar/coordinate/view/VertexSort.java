/*
 * Copyright © 2015 Integrated Knowledge Management (support@ikm.dev)
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
package dev.ikm.tinkar.coordinate.view;


import dev.ikm.tinkar.common.binary.Encodable;
import dev.ikm.tinkar.component.Concept;
import dev.ikm.tinkar.coordinate.language.calculator.LanguageCalculator;
import dev.ikm.tinkar.coordinate.navigation.calculator.Edge;
import dev.ikm.tinkar.coordinate.navigation.calculator.NavigationCalculator;
import dev.ikm.tinkar.entity.Entity;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.list.ImmutableList;

import java.util.UUID;

public interface VertexSort extends Encodable {

    /**
     * @return a unique identifier for this sort method
     */
    UUID getVertexSortUUID();

    String getVertexSortName();

    default String getVertexLabel(Concept vertexConcept, LanguageCalculator languageCalculator) {
        return getVertexLabel(Entity.nid(vertexConcept), languageCalculator);
    }

    String getVertexLabel(int vertexConceptNid, LanguageCalculator languageCalculator);

    /**
     * Sort the vertex concept nids with respect to settings from the
     * digraphCoordinate where appropriate.
     *
     * @param vertexConceptNids
     * @param navigationCalculator
     * @return sorted vertexConceptNids
     */
    int[] sortVertexes(int[] vertexConceptNids, NavigationCalculator navigationCalculator);

    ImmutableList<Edge> sortEdges(ImmutableCollection<Edge> edges, NavigationCalculator navigationCalculator);
}
