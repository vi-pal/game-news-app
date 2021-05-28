package com.example.gamenewsapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.gamenewsapp.R
import com.example.gamenewsapp.databinding.ActivityMainBinding
import com.example.gamenewsapp.presentation.fragments.NewsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val newsFragment = NewsFragment()

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        subscribeClicks()
        openNewsFragment()

    }

    private fun initUI() {
        toggle = ActionBarDrawerToggle(this, binding.dlMain, binding.tbMain, R.string.open, R.string.close)
        binding.dlMain.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun subscribeClicks() {
        binding.nvMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_settings -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            }
            true
        }

        binding.btnSearch.setOnClickListener {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openNewsFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container_main, newsFragment)
                .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }
}