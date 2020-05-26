import { Plugins } from '@capacitor/core';

const { NavigationBar } = Plugins;

export class Navigation {
  show() : Promise<void> {
    return NavigationBar.show();
  }
  hide() : Promise<void> {
    return NavigationBar.hide();
  }
}
