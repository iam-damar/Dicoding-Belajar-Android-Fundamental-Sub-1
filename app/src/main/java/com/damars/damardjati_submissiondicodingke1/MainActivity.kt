package com.damars.damardjati_submissiondicodingke1

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : MainAdapterUser
    private lateinit var mainuser : ArrayList<ForDataUser>

    private fun placementData() {
        this_NameData = resources.getStringArray(R.array.this_name)
        this_UsernameData = resources.getStringArray(R.array.this_username)
        this_AvatarData = resources.obtainTypedArray(R.array.avatar)
        this_following = resources.getStringArray(R.array.this_following)
        this_follower = resources.getStringArray(R.array.this_follower)
        this_companyData = resources.getStringArray(R.array.this_company)
        this_RepositoryData = resources.getStringArray(R.array.this_repository)
        this_LocationData = resources.getStringArray(R.array.this_location)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val thisactionbar = supportActionBar
        thisactionbar!!.title = "List of main User"

        Toast.makeText(this,"Selamat Datang!",Toast.LENGTH_SHORT).show()
        placementData()

        listviews.onItemClickListener = AdapterView.OnItemClickListener{
            _, _, position, _-> val listofUserData = ForDataUser("","","","","",0,"","")
            listofUserData.this_name = this_NameData[position]
            listofUserData.this_username = this_UsernameData[position]
            listofUserData.this_location = this_LocationData[position]
            listofUserData.this_follower = this_follower[position]
            listofUserData.this_following = this_following[position]
            listofUserData.avatar = this_AvatarData.getResourceId(position, position)
            listofUserData.this_company = this_companyData[position]
            listofUserData.this_repository = this_RepositoryData[position]

            val intent = Intent(this@MainActivity, forDetailUser::class.java)
            intent.putExtra(forDetailUser.EXTRA_DATA, listofUserData)
            this@MainActivity.startActivity(intent)
            Toast.makeText(this@MainActivity, mainuser[position].this_name,Toast.LENGTH_SHORT).show()
        }

        adapter = MainAdapterUser(this, addItem())
        listviews.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        moveMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun moveMode(clicked: Int) {
        when(clicked) {
            R.id.item_ribbon -> {
                val toAbout = Intent(this@MainActivity, Aboutcreator::class.java)
                startActivity(toAbout)
            }
        }
    }
    private fun addItem(): ArrayList<ForDataUser> {
        mainuser = ArrayList()
        for(j in this_NameData.indices) {
            val listuser = ForDataUser()

            listuser.this_name = this_NameData[j]
            listuser.this_location = this_LocationData[j]
            listuser.avatar = this_AvatarData.getResourceId(j, -1)
            listuser.this_company = this_companyData[j]
            mainuser.add(listuser)

        }
        return mainuser
    }
    private lateinit var this_NameData : Array<String>
    private lateinit var this_LocationData : Array<String>
    private lateinit var this_UsernameData : Array<String>
    private lateinit var this_AvatarData : TypedArray
    private lateinit var this_companyData : Array<String>
    private lateinit var this_following : Array<String>
    private lateinit var this_follower : Array<String>
    private lateinit var this_RepositoryData: Array<String>
}