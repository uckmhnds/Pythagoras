package com.uckmhnds.pythagoras.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uckmhnds.pythagoras.R
import com.uckmhnds.pythagoras.application.CalculatorApplication
import com.uckmhnds.pythagoras.databinding.FragmentScientificCalculatorBinding
import com.uckmhnds.pythagoras.model.entities.RecentAction
import com.uckmhnds.pythagoras.view.adapters.ScientificCalculatorCharacterAdapter
import com.uckmhnds.pythagoras.viewmodel.ScientificCalculatorViewModel
import com.uckmhnds.pythagoras.viewmodel.ScientificCalculatorViewModelFactory
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.RuntimeException
import java.util.*

class ScientificCalculatorFragment: Fragment(), View.OnClickListener  {

    private lateinit var binding: FragmentScientificCalculatorBinding

    private lateinit var recyclerview: RecyclerView

    private lateinit var layoutManager: LinearLayoutManager

    private lateinit var latestString: String
    private lateinit var latestChar: String
    private lateinit var stringBeforeDot: String

    private var latestList          = emptyArray<String>()

    private var stackFromEnd: Boolean = true

    private val viewModel: ScientificCalculatorViewModel by viewModels {
        ScientificCalculatorViewModelFactory((requireActivity().application as CalculatorApplication).repository)
    }

    private lateinit var calendar: Calendar

    private val icon: Int           = R.drawable.calculator_icon
    private val actionName: String  = "Scientific Calculation"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding                                     = FragmentScientificCalculatorBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        // RecyclerView adapter is implemented here to prevent error:
        // E/RecyclerView: No adapter attached; skipping layout

        // ScientificCalculatorCharacterAdapter settings

        recyclerview                                = binding.rvScientificCalcChar

        layoutManager                               = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        // Focus on the latest items
        layoutManager.stackFromEnd                  = stackFromEnd

        recyclerview.layoutManager                  = layoutManager

        recyclerview.adapter                        = ScientificCalculatorCharacterAdapter(activity, latestList)

        //

        latestString    = binding.resultTextView.text.toString()

        // Set onClickListeners
        binding.cvScientificIndex11.setOnClickListener(this)
        binding.cvScientificIndex12.setOnClickListener(this)
        binding.cvScientificIndex13.setOnClickListener(this)
        binding.cvScientificIndex14.setOnClickListener(this)
        binding.cvScientificIndex15.setOnClickListener(this)

        binding.cvScientificIndex21.setOnClickListener(this)
        binding.cvScientificIndex22.setOnClickListener(this)
        binding.cvScientificIndex23.setOnClickListener(this)
        binding.cvScientificIndex24.setOnClickListener(this)
        binding.cvScientificIndex25.setOnClickListener(this)

        binding.cvScientificIndex31.setOnClickListener(this)
        binding.cvScientificIndex32.setOnClickListener(this)
        binding.cvScientificIndex33.setOnClickListener(this)
        binding.cvScientificIndex34.setOnClickListener(this)
        binding.cvScientificIndex35.setOnClickListener(this)

        binding.cvScientificIndex41.setOnClickListener(this)
        binding.cvScientificIndex42.setOnClickListener(this)
        binding.cvScientificIndex43.setOnClickListener(this)
        binding.cvScientificIndex44.setOnClickListener(this)
        binding.cvScientificIndex45.setOnClickListener(this)

        binding.cvIndex11.setOnClickListener(this)
        binding.cvIndex12.setOnClickListener(this)
        binding.cvIndex13.setOnClickListener(this)
        binding.cvIndex14.setOnClickListener(this)
        binding.cvIndex15.setOnClickListener(this)

        binding.cvIndex21.setOnClickListener(this)
        binding.cvIndex22.setOnClickListener(this)
        binding.cvIndex23.setOnClickListener(this)
        binding.cvIndex24.setOnClickListener(this)
        binding.cvIndex25.setOnClickListener(this)

        binding.cvIndex31.setOnClickListener(this)
        binding.cvIndex32.setOnClickListener(this)
        binding.cvIndex33.setOnClickListener(this)
        binding.cvIndex34.setOnClickListener(this)
        binding.cvIndex35.setOnClickListener(this)

        binding.cvIndex41.setOnClickListener(this)
        binding.cvIndex42.setOnClickListener(this)
        binding.cvIndex43.setOnClickListener(this)
        binding.cvIndex44.setOnClickListener(this)
        binding.cvIndex45.setOnClickListener(this)




    }

    override fun onClick(view: View?) {

        if (view != null)
        {
            when(view.id)
            {
                R.id.cv_scientific_index_11 -> {
                    latestChar      = "sqrt("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_12 -> {
                    latestChar      = "("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_13 -> {
                    latestChar      = ")"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_14 -> {
                    latestChar      = "^(2)"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_15 -> {
                    latestChar      = "^("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                ////////////////////////////////
                R.id.cv_scientific_index_21 -> {
                    latestChar      = "sin("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_22 -> {
                    latestChar      = "cos("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_23 -> {
                    latestChar      = "tan("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_24 -> {
                    latestChar      = "log("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_25 -> {
                    latestChar      = "e"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                ////////////////////////////////
                R.id.cv_scientific_index_31 -> {
                    latestChar      = "sinh("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_32 -> {
                    latestChar      = "cosh("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_33 -> {
                    latestChar      = "tanh("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_34 -> {
                    latestChar      = "log2("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_35 -> {
                    latestChar      = "exp("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                ////////////////////////////////
                R.id.cv_scientific_index_41 -> {
                    latestChar      = "asin("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_42 -> {
                    latestChar      = "acos("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_43 -> {
                    latestChar      = "atan("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_44 -> {
                    latestChar      = "log10("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_scientific_index_45 -> {
                    latestChar      = "sig("
                    latestString    += latestChar

                    latestList      += latestChar
                }
                ////////////////////////////////
                R.id.cv_index_11 -> {
                    latestChar      = "7"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_12 -> {
                    latestChar      = "8"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_13 -> {
                    latestChar      = "9"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_14 -> {
                    latestString    = latestString.dropLast(1)

                    latestList      = latestList.dropLast(1).toTypedArray()
                }
                R.id.cv_index_15 -> {
                    latestString    = ""

                    latestList      = emptyArray()

                }
                R.id.cv_index_21 -> {
                    latestChar      = "4"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_22 -> {
                    latestChar      = "5"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_23 -> {
                    latestChar      = "5"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_24 -> {
                    latestChar      = "*"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_25 -> {
                    latestChar      = "/"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_31 -> {
                    latestChar      = "1"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_32 -> {
                    latestChar      = "2"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_33 -> {
                    latestChar      = "3"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_34 -> {
                    latestChar      = "+"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_35 -> {
                    latestChar      = "-"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_41 -> {
                    latestChar      = "0"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_42 -> {
                    latestChar      = "."
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_43 -> {
                    latestChar      = "pi"
                    latestString    += latestChar

                    latestList      += latestChar
                }
                R.id.cv_index_44 -> {

                    Toast.makeText(activity, "You have clicked prev button", Toast.LENGTH_SHORT).show()

                }
                R.id.cv_index_45 -> {

                    try {

                        var actionDetail: String    = latestString

                        // Evaluate the expression

                        val e: Expression           = ExpressionBuilder(latestString).build()

                        val result: Double          = e.evaluate()

                        latestString                = result.toString()

                        stringBeforeDot             = latestString.split(".")[0]

                        Log.i("BigValue", stringBeforeDot)

                        if (stringBeforeDot.length > 10){

                            Log.i("BigValue", stringBeforeDot)

                        }

                        latestList                  = latestString.split("").toTypedArray()

                        stackFromEnd                = false

                        // Save the action to RoomDB Part

                        actionDetail                += " = "
                        actionDetail                += latestString

                        val anAction                = RecentAction(0, actionName, actionDetail, getDate(), getTime(), icon, false)

                        insertDB(anAction)

                    }catch (e: RuntimeException){

                        if (latestString.isNotEmpty()) {
                            Toast.makeText(activity, "Check your formula!", Toast.LENGTH_SHORT)
                                .show()
                        }

                    }
                }
            }
        }

        inputExpressionAdapter(latestList, stackFromEnd)

        stackFromEnd                = true

    }

    private fun inputExpressionAdapter(itemsList: Array<String>, stackFromEnd: Boolean){

        // Focus on the latest items
        layoutManager.stackFromEnd                  = stackFromEnd

        recyclerview.adapter                        = ScientificCalculatorCharacterAdapter(activity, itemsList)

    }

    private fun insertDB(recentAction: RecentAction){
        viewModel.insert(recentAction)
    }

    private fun getDate(): String{

        calendar                    = Calendar.getInstance()

        val year                    = calendar.get(Calendar.YEAR)
        val month                   = calendar.get(Calendar.MONTH)
        val day                     = calendar.get(Calendar.DAY_OF_MONTH)

        return "${day}/${month}/${year}"
    }

    private fun getTime(): String{

        calendar                    = Calendar.getInstance()

        val hour                    = calendar.get(Calendar.HOUR_OF_DAY)
        val minute                  = calendar.get(Calendar.MINUTE)
        val second                  = calendar.get(Calendar.SECOND)

        var hourString              = ""
        var minuteString            = ""
        var secondString            = ""

        hourString = if (hour < 10){
            "0${hour}"
        } else{
            "$hour"
        }
        minuteString = if (minute < 10){
            "0${minute}"
        } else{
            "$minute"
        }
        secondString = if (second < 10){
            "0${second}"
        } else{
            "$second"
        }

        return "$hourString:$minuteString:$secondString"
    }

}