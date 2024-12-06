//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a RdGen v1.11.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------
using System;
using System.Linq;
using System.Collections.Generic;
using System.Runtime.InteropServices;
using JetBrains.Annotations;

using JetBrains.Core;
using JetBrains.Diagnostics;
using JetBrains.Collections;
using JetBrains.Collections.Viewable;
using JetBrains.Lifetimes;
using JetBrains.Serialization;
using JetBrains.Rd;
using JetBrains.Rd.Base;
using JetBrains.Rd.Impl;
using JetBrains.Rd.Tasks;
using JetBrains.Rd.Util;
using JetBrains.Rd.Text;


// ReSharper disable RedundantEmptyObjectCreationArgumentList
// ReSharper disable InconsistentNaming
// ReSharper disable RedundantOverflowCheckingContext


namespace org.example.generated.models
{
  
  
  /// <summary>
  /// <p>Generated from: ComplexModel.kt:5</p>
  /// </summary>
  public class ComplexModel : RdExtBase
  {
    //fields
    //public fields
    
    //private fields
    //primary constructor
    private ComplexModel(
    )
    {
    }
    //secondary constructor
    //deconstruct trait
    //statics
    
    
    
    protected override long SerializationHash => -119442132346258741L;
    
    protected override Action<ISerializers> Register => RegisterDeclaredTypesSerializers;
    public static void RegisterDeclaredTypesSerializers(ISerializers serializers)
    {
      serializers.Register(ReactiveClass.Read, ReactiveClass.Write);
      serializers.Register(ReactiveClass_Unknown.Read, ReactiveClass_Unknown.Write);
      
      serializers.RegisterToplevelOnce(typeof(DemoRoot), DemoRoot.RegisterDeclaredTypesSerializers);
    }
    
    public ComplexModel(Lifetime lifetime, IProtocol protocol) : this()
    {
      Identify(protocol.Identities, RdId.Root.Mix("ComplexModel"));
      Bind(lifetime, protocol, "ComplexModel");
    }
    
    //constants
    
    //custom body
    //methods
    //equals trait
    //hash code trait
    //pretty print
    public override void Print(PrettyPrinter printer)
    {
      printer.Println("ComplexModel (");
      printer.Print(")");
    }
    //toString
    public override string ToString()
    {
      var printer = new SingleLinePrettyPrinter();
      Print(printer);
      return printer.ToString();
    }
  }
  
  
  /// <summary>
  /// <p>Generated from: ComplexModel.kt:6</p>
  /// </summary>
  public class ReactiveClass : RdBindableBase
  {
    //fields
    //public fields
    [NotNull] public IViewableList<string> Values => _Values;
    
    //private fields
    [NotNull] protected readonly RdList<string> _Values;
    
    //primary constructor
    protected ReactiveClass(
      [NotNull] RdList<string> values
    )
    {
      if (values == null) throw new ArgumentNullException("values");
      
      _Values = values;
      _Values.OptimizeNested = true;
      BindableChildren.Add(new KeyValuePair<string, object>("values", _Values));
    }
    //secondary constructor
    public ReactiveClass (
    ) : this (
      new RdList<string>(JetBrains.Rd.Impl.Serializers.ReadString, JetBrains.Rd.Impl.Serializers.WriteString)
    ) {}
    //deconstruct trait
    //statics
    
    public static CtxReadDelegate<ReactiveClass> Read = (ctx, reader) => 
    {
      var _id = RdId.Read(reader);
      var values = RdList<string>.Read(ctx, reader, JetBrains.Rd.Impl.Serializers.ReadString, JetBrains.Rd.Impl.Serializers.WriteString);
      var _result = new ReactiveClass(values).WithId(_id);
      return _result;
    };
    
    public static CtxWriteDelegate<ReactiveClass> Write = (ctx, writer, value) => 
    {
      value.RdId.Write(writer);
      RdList<string>.Write(ctx, writer, value._Values);
    };
    
    //constants
    
    //custom body
    //methods
    //equals trait
    //hash code trait
    //pretty print
    public override void Print(PrettyPrinter printer)
    {
      printer.Println("ReactiveClass (");
      using (printer.IndentCookie()) {
        printer.Print("values = "); _Values.PrintEx(printer); printer.Println();
      }
      printer.Print(")");
    }
    //toString
    public override string ToString()
    {
      var printer = new SingleLinePrettyPrinter();
      Print(printer);
      return printer.ToString();
    }
  }
  
  
  public sealed class ReactiveClass_Unknown : ReactiveClass
  {
    //fields
    //public fields
    
    //private fields
    //primary constructor
    private ReactiveClass_Unknown(
      [NotNull] RdList<string> values
    ) : base (
      values
     ) 
    {
    }
    //secondary constructor
    public ReactiveClass_Unknown (
    ) : this (
      new RdList<string>(JetBrains.Rd.Impl.Serializers.ReadString, JetBrains.Rd.Impl.Serializers.WriteString)
    ) {}
    //deconstruct trait
    //statics
    
    public static new CtxReadDelegate<ReactiveClass_Unknown> Read = (ctx, reader) => 
    {
      var _id = RdId.Read(reader);
      var values = RdList<string>.Read(ctx, reader, JetBrains.Rd.Impl.Serializers.ReadString, JetBrains.Rd.Impl.Serializers.WriteString);
      var _result = new ReactiveClass_Unknown(values).WithId(_id);
      return _result;
    };
    
    public static new CtxWriteDelegate<ReactiveClass_Unknown> Write = (ctx, writer, value) => 
    {
      value.RdId.Write(writer);
      RdList<string>.Write(ctx, writer, value._Values);
    };
    
    //constants
    
    //custom body
    //methods
    //equals trait
    //hash code trait
    //pretty print
    public override void Print(PrettyPrinter printer)
    {
      printer.Println("ReactiveClass_Unknown (");
      using (printer.IndentCookie()) {
        printer.Print("values = "); _Values.PrintEx(printer); printer.Println();
      }
      printer.Print(")");
    }
    //toString
    public override string ToString()
    {
      var printer = new SingleLinePrettyPrinter();
      Print(printer);
      return printer.ToString();
    }
  }
}