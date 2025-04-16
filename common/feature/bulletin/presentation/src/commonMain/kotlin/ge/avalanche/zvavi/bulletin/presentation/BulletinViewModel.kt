package ge.avalanche.zvavi.bulletin.presentation
import base.BaseViewModel
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinAction
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState

class BulletinViewModel(): BaseViewModel<BulletinViewState, BulletinAction, BulletinEvent>(
    BulletinViewState.EMPTY) {
    override fun obtainEvent(viewEvent: BulletinEvent) {
    }
}