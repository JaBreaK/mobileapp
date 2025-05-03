package app.adetrifauzan.ui.gallery;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import app.adetrifauzan.R;
import app.adetrifauzan.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private final String bioText =
            "✨ Biodata Singkat ✨\n\n" +
                    "👤 Nama: Ade Tri Fauzan\n" +
                    "🎓 NIM: 221011401619\n" +
                    "🏫 Prodi: Teknik Informatika\n" +
                    "📍 Lokasi: Tangerang, Banten\n" +
                    "📧 Email: adetrifauzan@gmail.com\n";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        setupViews();
        initAnimations();
        setupClickListeners();
        return binding.getRoot();
    }

    private void setupViews() {
        binding.tvName.setText("Ade Tri Fauzan");
   }

    private void initAnimations() {
        binding.cardProfile.startAnimation(AnimationUtils.loadAnimation(
                requireContext(), R.anim.slide_up));

        binding.btnCopy.startAnimation(AnimationUtils.loadAnimation(
                requireContext(), R.anim.fade_in_delay));

        binding.btnShare.startAnimation(AnimationUtils.loadAnimation(
                requireContext(), R.anim.fade_in_delay));
    }

    private void setupClickListeners() {
        binding.btnCopy.setOnClickListener(v -> {
            animateButton(v);
            copyBioToClipboard();
        });

        binding.btnShare.setOnClickListener(v -> {
            animateButton(v);
            shareBio();
        });
    }

    private void animateButton(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(
                requireContext(), R.anim.button_scale));
    }

    private void copyBioToClipboard() {
        ClipboardManager clipboard = (ClipboardManager)
                requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Bio", bioText);
        clipboard.setPrimaryClip(clip);

        Toast.makeText(requireContext(),
                "Biodata tersalin ✔️", Toast.LENGTH_SHORT).show();
    }

    private void shareBio() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT, bioText);
        startActivity(Intent.createChooser(shareIntent, "Bagikan via"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}