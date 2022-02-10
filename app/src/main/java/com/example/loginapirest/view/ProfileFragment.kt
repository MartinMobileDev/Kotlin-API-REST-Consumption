package com.example.loginapirest.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.loginapirest.R
import com.example.loginapirest.databinding.FragmentProfileBinding
import com.example.loginapirest.viewModel.ProfileViewModel

class ProfileFragment : Fragment() {
    private lateinit var mBinding: FragmentProfileBinding
    private var mActivity: MainActivity? = null
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel.onCreate()

        profileViewModel.responseProfileData.observe(viewLifecycleOwner, { profile ->
            Glide.with(this)
                .load(profile.data?.avatar)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mBinding.ImgProfile)
            mBinding.tvUserName.text = "${profile.data?.firstName} ${profile.data?.lastName}"
            mBinding.tvUserEmail.text = "${profile.data?.email}"
            mBinding.tvUrlText.text = "${profile.support?.text}"
            mBinding.tvUrl.text = "${profile.support?.url}"
        })
        setupActionBar()
    }

    private fun setupActionBar() {
        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mActivity?.supportActionBar?.title = getString(R.string.profile_fragment)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mActivity?.onBackPressed()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onDestroy() {
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mActivity?.supportActionBar?.title = getString(R.string.app_name)

        setHasOptionsMenu(false)
        super.onDestroy()
    }
}