package com.chris.byteflow.tool

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.chris.byteflow.tool.adapter.ToolsAdapter
import com.chris.byteflow.tool.custom.GridGapItemDecoration
import com.chris.byteflow.tool.databinding.FragmentFirstBinding
import com.chris.byteflow.tool.enums.ToolsEntry
import com.chris.byteflow.tool.utils.dip2px

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val toolsAdapter = ToolsAdapter(this@FirstFragment.lifecycleScope) {
                when (this) {
                    ToolsEntry.NFC -> {
//                        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                        startActivity(Intent(context, NFCActivity::class.java))
                    }
                    ToolsEntry.BLE -> {
                    }
                    ToolsEntry.TTS -> {
                    }
                    else -> {}
                }

            }
            toolsAdapter.submitList(
                arrayListOf(ToolsEntry.NFC, ToolsEntry.BLE, ToolsEntry.TTS, ToolsEntry.WIFI)
            )
            binding.toolsRv.apply {
                addItemDecoration(GridGapItemDecoration(15.dip2px(context).toInt(), true))
                adapter = toolsAdapter
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}