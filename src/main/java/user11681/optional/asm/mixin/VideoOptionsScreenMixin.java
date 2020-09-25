package user11681.optional.asm.mixin;

import java.util.Arrays;
import java.util.List;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.VideoOptionsScreen;
import net.minecraft.client.gui.screen.options.GameOptionsScreen;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.Option;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import user11681.optional.asm.accessor.OptionalOption;
import user11681.optional.client.Optional;

@Mixin(VideoOptionsScreen.class)
public class VideoOptionsScreenMixin extends GameOptionsScreen {
    @Shadow
    @Final
    @Mutable
    @SuppressWarnings({"unused", "RedundantSuppression"})
    private static final Option[] OPTIONS = addButtons();

    public VideoOptionsScreenMixin(final Screen parent, final GameOptions gameOptions, final Text title) {
        super(parent, gameOptions, title);
    }

    @Accessor("OPTIONS")
    private static Option[] getOptions() {
        return null;
    }

    @Unique
    private static Option[] addButtons() {
        final Option[] options = getOptions();
        final List<OptionalOption> allOptions = Optional.getAllOptions();
        final int length = options.length;
        final Option[] newOptions = Arrays.copyOf(options, length + allOptions.size());

        for (int i = 0; i < allOptions.size(); i++) {
            newOptions[length + i] = allOptions.get(i).cast();
        }

        return newOptions;
    }
}
