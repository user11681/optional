package user11681.optional.asm.accessor;

import net.minecraft.client.options.Option;

public interface OptionalOption {
    Option cast();

    boolean reloadsResources();

    void setReloadsResources(boolean reloadsResources);

    String getNamespace();

    void setNamespace(String namespace);
}
