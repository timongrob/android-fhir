/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.fhir.catalog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/** Fragment for the component list. */
class ComponentListFragment : Fragment(R.layout.fragment_components) {
  private val viewModel: ComponentListViewModel by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setUpComponentsRecyclerView()
  }

  private fun setUpComponentsRecyclerView() {
    val adapter = ComponentsRecyclerViewAdapter().apply { submitList(viewModel.getComponentList()) }
    val recyclerView = requireView().findViewById<RecyclerView>(R.id.componentsRecyclerView)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
  }
}
