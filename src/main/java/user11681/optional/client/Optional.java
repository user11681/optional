package user11681.optional.client;

import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import java.util.List;
import java.util.Map;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.options.BooleanOption;
import net.minecraft.client.options.DoubleOption;
import net.minecraft.client.options.Option;
import net.minecraft.text.LiteralText;
import user11681.optional.asm.accessor.OptionalOption;

@Environment(EnvType.CLIENT)
public class Optional {
    private static final Map<String, List<OptionalOption>> options = new Reference2ReferenceOpenHashMap<>();

    public static double value;
    public static boolean hideArm;

    public static void init() {
        addVideoOption(new DoubleOption("optional", 123, 234, 2, o -> value, (o, d) -> value = d, (o, d) -> new LiteralText("optional: " + value)));
        addVideoOption(new BooleanOption("hide arm", o -> hideArm, (o, b) -> hideArm = b));
    }

    public static OptionalOption addVideoOption(final Option option) {
        return addVideoOption(option, false, "minecraft");
    }

    public static OptionalOption addVideoOption(final Option option, final String namespace) {
        return addVideoOption(option, false, namespace);
    }

    public static OptionalOption addVideoOption(final Option option, final boolean reloadsResources) {
        return addVideoOption(option, reloadsResources, "minecraft");
    }

    public static OptionalOption addVideoOption(final Option option, final boolean reloadsResources, final String namespace) {
        return addVideoOption((OptionalOption) option, reloadsResources, namespace);
    }

    public static OptionalOption addVideoOption(final OptionalOption option, final boolean reloadsResources, final String namespace) {
        List<OptionalOption> namespaceOptions = options.get(namespace);

        if (namespaceOptions == null) {
            namespaceOptions = new ReferenceArrayList<>();

            options.put(namespace, namespaceOptions);
        }

        option.setReloadsResources(reloadsResources);
        option.setNamespace(namespace);

        namespaceOptions.add(option);

        return option;
    }

    public static Map<String, List<OptionalOption>> getOptions() {
        return new Reference2ReferenceOpenHashMap<>(options);
    }

    public static List<OptionalOption> getAllOptions() {
        final List<OptionalOption> allOptions = new ReferenceArrayList<>();

        for (final List<OptionalOption> entry : options.values()) {
            allOptions.addAll(entry);
        }

        return allOptions;
    }
}
