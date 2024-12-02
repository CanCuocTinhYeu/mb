package net.minusmc.minusbounce.features.module.modules.movement.noslows.food

import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement
import net.minecraft.util.BlockPos
import net.minusmc.minusbounce.event.PreMotionEvent
import net.minusmc.minusbounce.features.module.modules.movement.noslows.NoSlowMode
import net.minusmc.minusbounce.utils.player.MovementUtils
import net.minusmc.minusbounce.utils.PacketUtils

class IntaveNoSlow : NoSlowMode("Intave") {
    override fun onPreMotion(event: PreMotionEvent) {
        if (MovementUtils.isMoving) {
            val currentItemSlot = mc.thePlayer.inventory.currentItem + 36
            val stack = mc.thePlayer.inventoryContainer.getSlot(currentItemSlot).stack

                    mc.netHandler.addToSendQueue(C08PacketPlayerBlockPlacement(BlockPos(-1, -1, -1), 255,
                    mc.thePlayer.inventoryContainer.getSlot(mc.thePlayer.inventory.currentItem + 36).stack, 0.0F, 0.0F, 0.0F))
                }
            }
        }