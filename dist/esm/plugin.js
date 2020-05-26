import { Plugins } from '@capacitor/core';
const { NavigationBar } = Plugins;
export class Navigation {
    show() {
        return NavigationBar.show();
    }
    hide() {
        return NavigationBar.hide();
    }
}
//# sourceMappingURL=plugin.js.map