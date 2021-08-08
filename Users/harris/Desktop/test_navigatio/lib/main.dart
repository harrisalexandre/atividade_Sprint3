import './material.dart';
import 'test_navigatioapp/generatediniciowidget/GeneratedInicioWidget.dart';
import 'test_navigatioapp/generatedloginwidget/GeneratedLoginWidget.dart';
import 'test_navigatioapp/generatedtela1widget/GeneratedTela1Widget.dart';
import 'test_navigatioapp/generatedtela2widget/GeneratedTela2Widget.dart';
import 'test_navigatioapp/generatedtela3widget/GeneratedTela3Widget.dart';

void main() {
  runApp(test_navigatioApp());
}

class test_navigatioApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      initialRoute: '/GeneratedLoginWidget',
      routes: {
        '/GeneratedDrawerWidget': (context) => GeneratedDrawerWidget(),
        '/GeneratedLoginWidget': (context) => GeneratedLoginWidget(),
        '/GeneratedInicioWidget': (context) => GeneratedInicioWidget(),
        '/GeneratedTela1Widget': (context) => GeneratedTela1Widget(),
        '/GeneratedTela2Widget': (context) => GeneratedTela2Widget(),
        '/GeneratedTela3Widget': (context) => GeneratedTela3Widget(),
      },
    );
  }
}

class StatelessWidget {}

class Colors {}
