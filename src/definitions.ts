declare module "@capacitor/core" {
  interface PluginRegistry {
    NavigationBar: NavigationBarPlugin;
  }
}

export interface NavigationBarPlugin {
  show(): Promise<void>;
  hide(): Promise<void>;
}
