package com.example.fitnessapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.DaysListItemBinding
import com.example.fitnessapp.databinding.ExerciseListItemBinding
import com.example.fitnessapp.utils.MainViewModel
import pl.droidsonroids.gif.GifDrawable

class ExerciseAdapter() : ListAdapter<ExerciseModel,ExerciseAdapter.ExerciseHolder>(MyComparator()){


    class ExerciseHolder(view : View) : RecyclerView.ViewHolder(view){
        private val binding = ExerciseListItemBinding.bind(view)


        fun setData(exercise : ExerciseModel) = with(binding){

            txtName2.text = exercise.name
             txtCount2.text = exercise.time
            chB.isChecked = exercise.isDone
            imEx.setImageDrawable(GifDrawable(root.context.assets, exercise.image))

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exercise_list_item,parent,false)
        return ExerciseHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseHolder, position: Int) {
        holder.setData(getItem(position))
    }

    class MyComparator : DiffUtil.ItemCallback<ExerciseModel>(){
        override fun areItemsTheSame(oldItem: ExerciseModel, newItem: ExerciseModel): Boolean {
                return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ExerciseModel, newItem: ExerciseModel): Boolean {
            return oldItem == newItem
        }

    }


}