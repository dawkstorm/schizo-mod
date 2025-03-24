package net.dawkstorm.schizo.item.custom;

import net.dawkstorm.schizo.SchizoMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class Summoner extends Item {
    public Summoner(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        ItemPlacementContext itemPlacementContext = new ItemPlacementContext(context);
        BlockPos blockPos = itemPlacementContext.getBlockPos();
        ItemStack itemStack = context.getStack();
        SchizoMod.LOGGER.info("creating magma cube");

        if (world instanceof ServerWorld serverWorld) {
            Consumer<MagmaCubeEntity> consumer = EntityType.copier(serverWorld, itemStack, context.getPlayer());
            MagmaCubeEntity magmaCubeEntity = EntityType.MAGMA_CUBE.create(serverWorld, consumer, blockPos, SpawnReason.SPAWN_ITEM_USE, true, true);
            if (magmaCubeEntity == null) {
                return ActionResult.FAIL;
            }
            serverWorld.spawnEntityAndPassengers(magmaCubeEntity);
        }
        return super.useOnBlock(context);
    }
}
