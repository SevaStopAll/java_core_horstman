public class OnDemandData {
    private OnDemandData() {}

    public OnDemandData getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final OnDemandData INSTANCE = new OnDemandData();
    }
}
