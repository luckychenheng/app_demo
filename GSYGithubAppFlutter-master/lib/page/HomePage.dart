import 'dart:async';

import 'package:flutter/material.dart';
import 'package:gsy_github_app_flutter/common/localization/DefaultLocalizations.dart';
import 'package:gsy_github_app_flutter/common/style/GSYStyle.dart';
import 'package:gsy_github_app_flutter/common/utils/CommonUtils.dart';
import 'package:gsy_github_app_flutter/common/utils/NavigatorUtils.dart';
import 'package:gsy_github_app_flutter/page/DynamicPage.dart';
import 'package:gsy_github_app_flutter/page/MyPage.dart';
import 'package:gsy_github_app_flutter/page/TrendPage.dart';
import 'package:gsy_github_app_flutter/widget/GSYTabBarWidget.dart';
import 'package:gsy_github_app_flutter/widget/GSYTitleBar.dart';
import 'package:gsy_github_app_flutter/widget/HomeDrawer.dart';

class HomePage extends StatefulWidget {
  static final String sName = "home";
  @override
  HomePageState createState() => new HomePageState();
}

/**
 * 主页
 * Created by guoshuyu
 * Date: 2018-07-16
 */
class HomePageState extends State<HomePage> {

  var _centerIndex = 0;

  final _key = new GlobalKey<ScaffoldState>();
  var _body;

  @override
  void initState() {
    super.initState();
  }

  @override
  void dispose() {
    super.dispose();
  }

  /// 单击提示退出
  Future<bool> _dialogExitApp(BuildContext context) {
    return showDialog(
        context: context,
        builder: (context) => new AlertDialog(
              content: new Text(CommonUtils.getLocale(context).app_back_tip),
              actions: <Widget>[
                new FlatButton(onPressed: () => Navigator.of(context).pop(false), child: new Text(CommonUtils.getLocale(context).app_cancel)),
                new FlatButton(
                    onPressed: () {
                      Navigator.of(context).pop(true);
                    },
                    child: new Text(CommonUtils.getLocale(context).app_ok))
              ],
            ));
  }

  _renderTab(icon, text) {
    return new Tab(
      child: new Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[new Icon(icon, size: 16.0), new Text(text)],
      ),
    );
  }

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    _initPage();
    List<Widget> tabs = [
      _renderTab(GSYICons.MAIN_DT, CommonUtils.getLocale(context).home_dynamic),
      _renderTab(GSYICons.MAIN_QS, CommonUtils.getLocale(context).home_trend),
      _renderTab(GSYICons.MAIN_MY, CommonUtils.getLocale(context).home_my),
    ];
//    return WillPopScope(
//      onWillPop: () {
//        return _dialogExitApp(context);
//      },
//      child: new GSYTabBarWidget(
//        drawer: new HomeDrawer(),
//        type: GSYTabBarWidget.BOTTOM_TAB,
//        tabItems: tabs,
//        tabViews: [
//          new DynamicPage(),
//          new TrendPage(),
//          new MyPage(),
//        ],
//        backgroundColor: GSYColors.primarySwatch,
//        indicatorColor: Color(GSYColors.white),
//        title: GSYTitleBar(
//          GSYLocalizations.of(context).currentLocalized.app_name,
//          iconData: GSYICons.MAIN_SEARCH,
//          needRightLocalIcon: true,
//          onPressed: () {
//            NavigatorUtils.goSearchPage(context);
//          },
//        ),
//      ),
//    );

    return new WillPopScope(child: new Scaffold(
      key: _key,
      appBar: new AppBar(
        title: new Text("title"),
        centerTitle: true,
      ), //头部的标题AppBar
//      drawer: new Drawer(
//        child: new DrawerPage(),
//      ),
      bottomNavigationBar: new BottomNavigationBar(
        items: [
          new BottomNavigationBarItem(
              icon: new Icon(Icons.home), title: new Text("首页")),
          new BottomNavigationBarItem(
              icon: new Icon(Icons.home), title: new Text("赚赚")),
          new BottomNavigationBarItem(
              icon: new Icon(Icons.home), title: new Text("我的")),
        ],
        currentIndex: _centerIndex,
        type: BottomNavigationBarType.fixed,
        onTap: (index) {
          setState(() {
            _centerIndex = index;
          });
        },
      ),
      body: _body,
    ), onWillPop: () {
      print("===> onWillPop <===");
    });
  }

  _initPage() {
    _body = new IndexedStack(
      children: <Widget>[
        new DynamicPage(),
        new TrendPage(),
        new MyPage(),
      ],
      index: _centerIndex,
    );
  }
}
