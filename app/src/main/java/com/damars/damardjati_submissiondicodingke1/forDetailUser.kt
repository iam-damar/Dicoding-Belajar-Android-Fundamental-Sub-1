package com.damars.damardjati_submissiondicodingke1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_for_detail_user.*

class forDetailUser : AppCompatActivity() {

    companion object{
        var EXTRA_DATA = "0"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_detail_user)
        val listUser : ForDataUser = intent.getParcelableExtra(EXTRA_DATA)!!

        val foractionbar = supportActionBar
        foractionbar!!.title = "Detail of User"

        tv_onNama_detail.text = listUser.this_name
        tv_onUsername_detail.text = getString(R.string.this_username, listUser.this_username)
        tv_onavatar_detail.setImageResource(listUser.avatar!!)
        tv_onCompany_detail.text = getString(R.string.this_company, listUser.this_company)
        tv_onLocation_detail.text = getString(R.string.this_location, listUser.this_location)
        tv_onfollowing_detail.text = getString(R.string.this_following, listUser.this_following)
        tv_onfollower_detail.text = getString(R.string.this_follower, listUser.this_follower)
        tv_onRepository_detail.text = getString(R.string.this_repository, listUser.this_repository)
    }
}