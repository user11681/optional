package user11681.optional.asm.mixin;

import net.minecraft.client.options.Option;
import org.spongepowered.asm.mixin.Mixin;
import user11681.optional.asm.accessor.OptionalOption;

@Mixin(Option.class)
public class OptionMixin implements OptionalOption {
    private final Option self = (Option) (Object) this;

    public String namespace;
    public boolean reloadsResources;

    public OptionMixin(final String namespace, final boolean reloadsResources) {
        this.namespace = namespace;
        this.reloadsResources = reloadsResources;
    }

    @Override
    public Option cast() {
        return self;
    }

    @Override
    public boolean reloadsResources() {
        return this.reloadsResources;
    }

    @Override
    public void setReloadsResources(final boolean reloadsResources) {
        this.reloadsResources = reloadsResources;
    }

    @Override
    public String getNamespace() {
        return this.namespace;
    }

    @Override
    public void setNamespace(final String namespace) {
        this.namespace = namespace;
    }
}
