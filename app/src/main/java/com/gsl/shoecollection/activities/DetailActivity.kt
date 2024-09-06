package com.gsl.shoecollection.activities

import android.annotation.SuppressLint
import android.os.Bundle
import com.gsl.shoecollection.databinding.ActivityDetailBinding
import com.gsl.shoecollection.helper.ManagementCart
import com.gsl.shoecollection.model.ItemsModel

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel
    private lateinit var managementCart: ManagementCart
    private var numberOder = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managementCart = ManagementCart(this)

        getBundle()

    }

    @SuppressLint("SetTextI18n")
    private fun getBundle() {
        item = intent.getParcelableExtra("object")!!

        binding.titleText.text = item.title
        binding.discription.text = item.discription
        binding.priceText.text = "$"+item.price

    }
}