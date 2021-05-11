package com.meaning.virtualfitting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.meaning.virtualfitting.ui.fragment.PersonalFragment
import com.meaning.virtualfitting.ui.fragment.RecommendFragment
import kotlinx.android.synthetic.main.activity_root.*

class RootActivity : AppCompatActivity() {

    private var flag = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)
        val recommendFragment = RecommendFragment()
        val personalFragment = PersonalFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fl_content, recommendFragment)
            .commit()
        initView()
        iv_main_try_on.setOnClickListener {
            when (flag) {
                1 -> {
                    iv_main_daily_recommend.setImageResource(R.drawable.iv_main_daily_recommend_unchecked)
                    iv_main_daily_recommend_checked_line.visibility = View.GONE
                }
                2 -> {
                    iv_main_mine.setImageResource(R.drawable.iv_main_mine_unchecked)
                    iv_main_mine_checked_line.visibility = View.GONE
                }
            }
            iv_main_try_on.setImageResource(R.drawable.iv_main_try_on_checked)
            iv_main_try_on_checked_line.visibility = View.VISIBLE
            flag = 0
        }
        iv_main_daily_recommend.setOnClickListener {
            when (flag) {
                0 -> {
                    iv_main_try_on.setImageResource(R.drawable.iv_main_try_on_unchecked)
                    iv_main_try_on_checked_line.visibility = View.GONE
                }
                2 -> {
                    iv_main_mine.setImageResource(R.drawable.iv_main_mine_unchecked)
                    iv_main_mine_checked_line.visibility = View.GONE
                }
            }
            iv_main_daily_recommend.setImageResource(R.drawable.iv_main_daily_recommend_unchecked)
            iv_main_daily_recommend_checked_line.visibility = View.VISIBLE
            flag = 1

            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fl_content, recommendFragment)
            fragmentTransaction.commit()
        }
        iv_main_mine.setOnClickListener {
            when (flag) {
                0 -> {
                    iv_main_try_on.setImageResource(R.drawable.iv_main_try_on_unchecked)
                    iv_main_try_on_checked_line.visibility = View.GONE
                }
                1 -> {
                    iv_main_daily_recommend.setImageResource(R.drawable.iv_main_daily_recommend_unchecked)
                    iv_main_daily_recommend_checked_line.visibility = View.GONE

                }
            }
            iv_main_mine.setImageResource(R.drawable.iv_main_mine_checked)
            iv_main_mine_checked_line.visibility = View.VISIBLE
            flag = 2

            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fl_content, personalFragment)
            fragmentTransaction.commit()
        }
    }

    private fun initView() {
        //初始化ui
        iv_main_daily_recommend.setImageResource(R.drawable.iv_main_daily_recommend_unchecked)
        iv_main_daily_recommend_checked_line.visibility = View.VISIBLE
        flag = 1
    }

}