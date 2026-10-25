package dev.fastshield;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.item.Items;

public class FastShield implements ModInitializer {
	// Vanilla shield delay is 0.25 s = 5 ticks. 3 ticks = 0.15 s.
	private static final float BLOCK_DELAY_SECONDS = 0.15f;

	@Override
	public void onInitialize() {
		// The shield already has a "blocks_attacks" component. We copy it and only
		// change the block delay, so damage reduction, sounds, etc. stay the same.
		DefaultItemComponentEvents.MODIFY.register(context ->
			context.modify(
				item -> item == Items.SHIELD,
				(builder, item) -> {
					BlocksAttacksComponent old = item.getComponents().get(DataComponentTypes.BLOCKS_ATTACKS);
					if (old == null) return;
					builder.add(DataComponentTypes.BLOCKS_ATTACKS, new BlocksAttacksComponent(
						BLOCK_DELAY_SECONDS,
						old.disableCooldownScale(),
						old.damageReductions(),
						old.itemDamage(),
						old.bypassedBy(),
						old.blockSound(),
						old.disableSound()
					));
				}));
	}
}
