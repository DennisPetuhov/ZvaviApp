package bulletin
import base.BaseViewModel
import bulletin.models.BulletinAction
import bulletin.models.BulletinEvent
import bulletin.models.BulletinViewState

class BulletinViewModel(): BaseViewModel<BulletinViewState, BulletinAction, BulletinEvent>(BulletinViewState.EMPTY) {
    override fun obtainEvent(viewEvent: BulletinEvent) {

    }

}