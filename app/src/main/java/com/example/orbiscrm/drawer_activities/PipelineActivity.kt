package com.example.orbiscrm.drawer_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityPipelineBinding
import dev.bandb.graphview.AbstractGraphAdapter
import dev.bandb.graphview.graph.Graph
import dev.bandb.graphview.graph.Node
import dev.bandb.graphview.layouts.tree.BuchheimWalkerConfiguration
import dev.bandb.graphview.layouts.tree.BuchheimWalkerLayoutManager
import dev.bandb.graphview.layouts.tree.TreeEdgeDecoration

class PipelineActivity : AppCompatActivity() {
    private lateinit var layout: ActivityPipelineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityPipelineBinding.inflate(layoutInflater)
        setContentView(layout.root)


    }

//    private fun setupGraphView (){
//
//        val configuration = BuchheimWalkerConfiguration.Builder()
//            .setSiblingSeparation(100)
//            .setLevelSeparation(100)
//            .setSubtreeSeparation(100)
//            .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_TOP_BOTTOM)
//            .build()
//        layout.recycler.layoutManager =BuchheimWalkerLayoutManager(this,configuration)
//
//        layout.recycler.addItemDecoration(TreeEdgeDecoration())
//
//        val graph = Graph()
//        val node1 = Node("Parent")
//        val node2 = Node("Child 1")
//        val node3 = Node("Child 2")
//
//        graph.addEdge(node1, node2)
//        graph.addEdge(node1, node3)
//
//        val adapter = object:AbstractGraphAdapter<NodeViewHolder>(){
//            override fun onBindViewHolder(holder: NodeViewHolder, position: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NodeViewHolder {
//                TODO("Not yet implemented")
//            }
//
//            class NodeViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
//            {
//
//            }
//        }
//
//    }
}