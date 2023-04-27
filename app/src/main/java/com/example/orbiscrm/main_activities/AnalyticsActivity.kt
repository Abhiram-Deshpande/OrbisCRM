package com.example.orbiscrm.main_activities

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orbiscrm.R
import com.example.orbiscrm.databinding.ActivityAnalyticsBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF

class AnalyticsActivity : AppCompatActivity() {
    private lateinit var layout:ActivityAnalyticsBinding
    private lateinit var list:ArrayList<BarEntry>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityAnalyticsBinding.inflate(layoutInflater)
        setContentView(layout.root)


    }

    override fun onStart() {
        super.onStart()
        setPieChart()
        setBarChart()

        
    }
    
    private fun setPieChart(){
        layout.pieChart.setUsePercentValues(true)
        layout.pieChart.getDescription().setEnabled(false)
        layout.pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

        // on below line we are setting drag for our pie chart
        layout.pieChart.setDragDecelerationFrictionCoef(0.95f)

        // on below line we are setting hole
        // and hole color for pie chart


        // on below line we are setting circle color and alpha
        layout.pieChart.setTransparentCircleColor(Color.WHITE)
        layout.pieChart.setTransparentCircleAlpha(110)

        // on  below line we are setting hole radius
        layout.pieChart.setHoleRadius(58f)
        layout.pieChart.setTransparentCircleRadius(61f)

        // on below line we are setting center text
        layout.pieChart.setDrawCenterText(true)

        // on below line we are setting
        // rotation for our pie chart
        layout.pieChart.setRotationAngle(0f)

        // enable rotation of the layout.pieChart by touch
        layout.pieChart.setRotationEnabled(true)
        layout.pieChart.setHighlightPerTapEnabled(true)

        // on below line we are setting animation for our pie chart
        layout.pieChart.animateY(1400, Easing.EaseInOutQuad)

        // on below line we are disabling our legend for pie chart
        layout.pieChart.legend.isEnabled = false
        layout.pieChart.setEntryLabelColor(Color.WHITE)
        layout.pieChart.setEntryLabelTextSize(12f)

        // on below line we are creating array list and
        // adding data to it to display in pie chart
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(70f))
        entries.add(PieEntry(20f))
        entries.add(PieEntry(10f))

        // on below line we are setting pie data set
        val dataSet = PieDataSet(entries, "")

        // on below line we are setting icons.
        dataSet.setDrawIcons(false)

        // on below line we are setting slice for pie
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        // add a lot of colors to list
        val colors: ArrayList<Int> = ArrayList()
        colors.add(resources.getColor(R.color.purple_200))
        colors.add(resources.getColor(R.color.yellow))
        colors.add(resources.getColor(R.color.red))

        // on below line we are setting colors.
        dataSet.colors = colors

        // on below line we are setting pie data set
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        layout.pieChart.setData(data)

        // undo all highlights
        layout.pieChart.highlightValues(null)

        // loading chart
        layout.pieChart.invalidate()
    }

    private fun setBarChart(){
        list = ArrayList()
        list.add(BarEntry(2010f,1000f))
        list.add(BarEntry(2011f,2000f))
        list.add(BarEntry(2012f,330f))
        list.add(BarEntry(2013f,4000f))
        list.add(BarEntry(2014f,1000f))
        list.add(BarEntry(2015f,2000f))
        list.add(BarEntry(2016f,7000f))
        list.add(BarEntry(2017f,1000f))
        list.add(BarEntry(2018f,1300f))
        list.add(BarEntry(2019f,750f))
        list.add(BarEntry(2020f,3500f))

        val dataset = BarDataSet(list,"Report")

        dataset.setDrawIcons(false)
        dataset.setDrawValues(false)

        val colors:ArrayList<Int> = ArrayList()
        colors.add(resources.getColor(R.color.purple_200))
        colors.add(resources.getColor(R.color.yellow))
        colors.add(resources.getColor(R.color.red))

        dataset.colors = colors

        val data = BarData(dataset)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        layout.barChart.setData(data)


        layout.barChart.getDescription().setEnabled(false)
        layout.barChart.setExtraOffsets(5f, 10f, 5f, 5f)

        // on below line we are setting drag for our pie chart
        layout.barChart.setDragDecelerationFrictionCoef(0.95f)

        // on below line we are setting hole
        // and hole color for pie chart
        layout.barChart.setBackgroundColor(Color.WHITE)



        // enable rotation of the layout.barChart by touch
        layout.barChart.setHighlightPerTapEnabled(true)

        // on below line we are setting animation for our pie chart
        layout.barChart.animateY(1400, Easing.EaseInOutQuad)

        // on below line we are disabling our legend for pie chart
        layout.barChart.legend.isEnabled = false

        // undo all highlights
        layout.barChart.highlightValues(null)

        // loading chart
        layout.barChart.invalidate()
    }
}