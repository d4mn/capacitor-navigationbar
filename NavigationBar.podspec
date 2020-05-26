
  Pod::Spec.new do |s|
    s.name = 'NavigationBar'
    s.version = '0.0.1'
    s.summary = 'Show hide navigation bar'
    s.license = 'MIT'
    s.homepage = 'https://github.com/d4mn/capacitor-navigationbar.git'
    s.author = 'd4Mn'
    s.source = { :git => 'https://github.com/d4mn/capacitor-navigationbar.git', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '11.0'
    s.dependency 'Capacitor'
  end