package com.acmday.design.pattern.server;

import com.acmday.design.pattern.server.chainOfResponsibility.*;
import com.acmday.design.pattern.server.command.*;
import com.acmday.design.pattern.server.iterator.DinerMenu;
import com.acmday.design.pattern.server.iterator.Iterator;
import com.acmday.design.pattern.server.iterator.MenuItem;
import com.acmday.design.pattern.server.mediator.ConcreteMediator;
import com.acmday.design.pattern.server.mediator.LiSi;
import com.acmday.design.pattern.server.mediator.ZhangSan;
import com.acmday.design.pattern.server.memento.ChessmanOriginator;
import com.acmday.design.pattern.server.memento.Client;
import com.acmday.design.pattern.server.observer.CctvNewsSubject;
import com.acmday.design.pattern.server.observer.DriverObserver;
import com.acmday.design.pattern.server.observer.Subject;
import com.acmday.design.pattern.server.observer.TeacherObserver;
import com.acmday.design.pattern.server.state.FreeState;
import com.acmday.design.pattern.server.state.RoomContext;
import com.acmday.design.pattern.server.strategy.OldCustomerManyStrategy;
import com.acmday.design.pattern.server.strategy.StrategyHandler;
import com.acmday.design.pattern.server.template.AbstractCaffeineBeverageWithHook;
import com.acmday.design.pattern.server.template.CoffeeWithHookAbstract;
import com.acmday.design.pattern.server.visitor.BusinessReport;
import com.acmday.design.pattern.server.visitor.CeoVisitor;
import com.acmday.design.pattern.server.visitor.CtoVisitor;
import org.junit.Test;

/**
 * @author acmday.
 * @date 2020/7/16.
 * 行为型模式共十一种：
 * 观察者模式、访问者模式、责任链模式、迭代子模式、
 * 策略模式、模板方法模式、状态模式、
 * 命令模式、中介者模式、解释器模式、备忘录模式.
 */
public class BehaviorType {

    @Test
    public void testMemento(){
        com.acmday.design.pattern.server.memento.Client.play();
    }

    @Test
    public void interpreter() {
        //应用场景比较窄，略。
    }

    @Test
    public void mediator() {
        ConcreteMediator mediator = new ConcreteMediator();
        LiSi liSi = new LiSi(mediator);
        mediator.setLiSi(liSi);
        ZhangSan zhangSan = new ZhangSan(mediator);
        mediator.setZhangSan(zhangSan);

        zhangSan.send("你在哪？");
        liSi.response("北京！");
    }

    @Test
    public void command() {
        Command bakeMuttonCommand = new BakeMuttonCommand(new Barbecuer("烤羊肉"));
        Command bakeChickenWingCommand = new BakeChickenWingCommand(new Barbecuer("烤鸡翅"));

        Waiter girl = new Waiter();
        girl.addOrder(bakeChickenWingCommand);
        girl.addOrder(bakeMuttonCommand);

        girl.notifyMessage();
    }

    @Test
    public void state() {
        RoomContext context = new RoomContext();
        context.setState(new FreeState());
        context.request(10010);
        /*context.setState(new BookedState());
        context.request(10010);
        context.setState(new CheckedInState());
        context.request(10010);*/
    }

    @Test
    public void template() {
        AbstractCaffeineBeverageWithHook coffeHook = new CoffeeWithHookAbstract();
        coffeHook.prepare();
    }

    @Test
    public void strategy() {
        StrategyHandler handler = new StrategyHandler(new OldCustomerManyStrategy());
        Double price = handler.getPrice(1000);
        System.out.println("实际价格：" + price);
    }

    @Test
    public void iterator() {

        MenuItem[] menuItems = new MenuItem[10];

        DinerMenu dinerMenu = new DinerMenu(menuItems);
        Iterator iterator = dinerMenu.createIterator();

        for(int i=0; i<7; ++i) {
            String elem = String.valueOf(i);
            dinerMenu.addItem(new MenuItem(elem, elem, elem, elem));
        }
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void chainOfResponsibility() {

        ILeave leave = new Leave("小花",5,"身体不适");

        AbstractHandler groupLeader = new GroupLeader();
        AbstractHandler manager = new DeptManager();
        AbstractHandler bigManager = new BigManager();

        groupLeader.setNextHandler(manager);
        manager.setNextHandler(bigManager);

        groupLeader.submit(leave);
    }

    @Test
    public void visitor() {
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new CeoVisitor());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new CtoVisitor());
    }

    @Test
    public void observer() {
        Subject subject = new CctvNewsSubject();
        TeacherObserver teacherObserver = new TeacherObserver();
        subject.add(teacherObserver);
        DriverObserver driverObserver = new DriverObserver();
        subject.add(driverObserver);

        subject.notifyObserver("明天是晴天！");
        subject.remove(teacherObserver);
        subject.notifyObserver("后屯路交通管制！");

        // TODO: 2020/7/18  委托事件模型
    }
}
