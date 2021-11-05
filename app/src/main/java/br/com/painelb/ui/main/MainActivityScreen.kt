package br.com.painelb.ui.main

import android.content.Intent
import br.com.painelb.base.navigation.ActivityScreen
import br.com.painelb.base.ui.BaseActivity
import kotlin.reflect.KClass

class MainActivityScreen constructor(private val needClearStack: Boolean) : ActivityScreen() {

    companion object {
        private const val NEED_TO_CLEAR_STACK = "MainActivityScreen.ClearStack"
    }

    override fun activityClass(): KClass<out BaseActivity<*>> = MainActivity::class

    override
    fun configureIntent(intent: Intent) {
        if (needClearStack) {
            intent.flags = (Intent.FLAG_ACTIVITY_NO_ANIMATION
                    or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    or Intent.FLAG_ACTIVITY_NEW_TASK
                    or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.putExtra(NEED_TO_CLEAR_STACK, needClearStack)
        }
    }
}
