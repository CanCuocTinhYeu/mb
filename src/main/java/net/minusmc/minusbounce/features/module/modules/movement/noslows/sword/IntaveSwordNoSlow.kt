package net.minusmc.minusbounce.features.module.modules.movement.noslows.sword

import net.minecraft.network.play.client.C09PacketHeldItemChange
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement
import net.minecraft.util.BlockPos
import net.minusmc.minusbounce.event.PreMotionEvent
import net.minusmc.minusbounce.features.module.modules.movement.noslows.NoSlowMode
import net.minusmc.minusbounce.utils.player.MovementUtils

class IntaveSwordNoSlow : NoSlowMode("Intave") {
    override fun onPreMotion(event: PreMotionEvent) {
        if (MovementUtils.isMoving) {
            val currentItem = mc.thePlayer.inventory.currentItem
            val heldItem = mc.thePlayer.heldItem

            mc.netHandler.addToSendQueue(C09PacketHeldItemChange(currentItem))
            if (heldItem != null) {
                mc.netHandler.addToSendQueue(C08PacketPlayerBlockPlacement(BlockPos(-1, -1, -1), 255, mc.thePlayer.heldItem, 0f, 0f, 0f))
            }
        }
    }
}
