package com.semarescue.android.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.semarescue.android.data.dao.EmergencyContactDao;
import com.semarescue.android.data.dao.EmergencyContactDao_Impl;
import com.semarescue.android.data.dao.IncidentLogDao;
import com.semarescue.android.data.dao.IncidentLogDao_Impl;
import com.semarescue.android.data.dao.InstructionDao;
import com.semarescue.android.data.dao.InstructionDao_Impl;
import com.semarescue.android.data.dao.MedicalProfileDao;
import com.semarescue.android.data.dao.MedicalProfileDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile InstructionDao _instructionDao;

  private volatile EmergencyContactDao _emergencyContactDao;

  private volatile MedicalProfileDao _medicalProfileDao;

  private volatile IncidentLogDao _incidentLogDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `instructions` (`id` TEXT NOT NULL, `title_en` TEXT NOT NULL, `title_sw` TEXT NOT NULL, `icon_asset` TEXT NOT NULL, `category` TEXT NOT NULL, `keywords` TEXT NOT NULL, `description_en` TEXT, `description_sw` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `steps` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `instruction_id` TEXT NOT NULL, `step_number` INTEGER NOT NULL, `text_en` TEXT NOT NULL, `text_sw` TEXT NOT NULL, `audio_asset_en` TEXT, `audio_asset_sw` TEXT, `graphic_asset` TEXT, `timer_seconds` INTEGER, FOREIGN KEY(`instruction_id`) REFERENCES `instructions`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_steps_instruction_id` ON `steps` (`instruction_id`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `emergency_contacts` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `phone` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `medical_profile` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `bloodType` TEXT NOT NULL, `allergies` TEXT NOT NULL, `medications` TEXT NOT NULL, `emergencyNotes` TEXT NOT NULL, `isOrganDonor` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `incident_log` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `description` TEXT NOT NULL, `category` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ef436edafe036e1621463af086e9f172')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `instructions`");
        db.execSQL("DROP TABLE IF EXISTS `steps`");
        db.execSQL("DROP TABLE IF EXISTS `emergency_contacts`");
        db.execSQL("DROP TABLE IF EXISTS `medical_profile`");
        db.execSQL("DROP TABLE IF EXISTS `incident_log`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsInstructions = new HashMap<String, TableInfo.Column>(8);
        _columnsInstructions.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstructions.put("title_en", new TableInfo.Column("title_en", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstructions.put("title_sw", new TableInfo.Column("title_sw", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstructions.put("icon_asset", new TableInfo.Column("icon_asset", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstructions.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstructions.put("keywords", new TableInfo.Column("keywords", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstructions.put("description_en", new TableInfo.Column("description_en", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstructions.put("description_sw", new TableInfo.Column("description_sw", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInstructions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInstructions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInstructions = new TableInfo("instructions", _columnsInstructions, _foreignKeysInstructions, _indicesInstructions);
        final TableInfo _existingInstructions = TableInfo.read(db, "instructions");
        if (!_infoInstructions.equals(_existingInstructions)) {
          return new RoomOpenHelper.ValidationResult(false, "instructions(com.semarescue.android.data.entities.Instruction).\n"
                  + " Expected:\n" + _infoInstructions + "\n"
                  + " Found:\n" + _existingInstructions);
        }
        final HashMap<String, TableInfo.Column> _columnsSteps = new HashMap<String, TableInfo.Column>(9);
        _columnsSteps.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("instruction_id", new TableInfo.Column("instruction_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("step_number", new TableInfo.Column("step_number", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("text_en", new TableInfo.Column("text_en", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("text_sw", new TableInfo.Column("text_sw", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("audio_asset_en", new TableInfo.Column("audio_asset_en", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("audio_asset_sw", new TableInfo.Column("audio_asset_sw", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("graphic_asset", new TableInfo.Column("graphic_asset", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("timer_seconds", new TableInfo.Column("timer_seconds", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSteps = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSteps.add(new TableInfo.ForeignKey("instructions", "CASCADE", "NO ACTION", Arrays.asList("instruction_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSteps = new HashSet<TableInfo.Index>(1);
        _indicesSteps.add(new TableInfo.Index("index_steps_instruction_id", false, Arrays.asList("instruction_id"), Arrays.asList("ASC")));
        final TableInfo _infoSteps = new TableInfo("steps", _columnsSteps, _foreignKeysSteps, _indicesSteps);
        final TableInfo _existingSteps = TableInfo.read(db, "steps");
        if (!_infoSteps.equals(_existingSteps)) {
          return new RoomOpenHelper.ValidationResult(false, "steps(com.semarescue.android.data.entities.Step).\n"
                  + " Expected:\n" + _infoSteps + "\n"
                  + " Found:\n" + _existingSteps);
        }
        final HashMap<String, TableInfo.Column> _columnsEmergencyContacts = new HashMap<String, TableInfo.Column>(3);
        _columnsEmergencyContacts.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmergencyContacts.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmergencyContacts.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmergencyContacts = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEmergencyContacts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEmergencyContacts = new TableInfo("emergency_contacts", _columnsEmergencyContacts, _foreignKeysEmergencyContacts, _indicesEmergencyContacts);
        final TableInfo _existingEmergencyContacts = TableInfo.read(db, "emergency_contacts");
        if (!_infoEmergencyContacts.equals(_existingEmergencyContacts)) {
          return new RoomOpenHelper.ValidationResult(false, "emergency_contacts(com.semarescue.android.data.entities.EmergencyContact).\n"
                  + " Expected:\n" + _infoEmergencyContacts + "\n"
                  + " Found:\n" + _existingEmergencyContacts);
        }
        final HashMap<String, TableInfo.Column> _columnsMedicalProfile = new HashMap<String, TableInfo.Column>(7);
        _columnsMedicalProfile.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicalProfile.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicalProfile.put("bloodType", new TableInfo.Column("bloodType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicalProfile.put("allergies", new TableInfo.Column("allergies", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicalProfile.put("medications", new TableInfo.Column("medications", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicalProfile.put("emergencyNotes", new TableInfo.Column("emergencyNotes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicalProfile.put("isOrganDonor", new TableInfo.Column("isOrganDonor", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMedicalProfile = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMedicalProfile = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMedicalProfile = new TableInfo("medical_profile", _columnsMedicalProfile, _foreignKeysMedicalProfile, _indicesMedicalProfile);
        final TableInfo _existingMedicalProfile = TableInfo.read(db, "medical_profile");
        if (!_infoMedicalProfile.equals(_existingMedicalProfile)) {
          return new RoomOpenHelper.ValidationResult(false, "medical_profile(com.semarescue.android.data.entities.MedicalProfile).\n"
                  + " Expected:\n" + _infoMedicalProfile + "\n"
                  + " Found:\n" + _existingMedicalProfile);
        }
        final HashMap<String, TableInfo.Column> _columnsIncidentLog = new HashMap<String, TableInfo.Column>(4);
        _columnsIncidentLog.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncidentLog.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncidentLog.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncidentLog.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIncidentLog = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIncidentLog = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIncidentLog = new TableInfo("incident_log", _columnsIncidentLog, _foreignKeysIncidentLog, _indicesIncidentLog);
        final TableInfo _existingIncidentLog = TableInfo.read(db, "incident_log");
        if (!_infoIncidentLog.equals(_existingIncidentLog)) {
          return new RoomOpenHelper.ValidationResult(false, "incident_log(com.semarescue.android.data.entities.IncidentLog).\n"
                  + " Expected:\n" + _infoIncidentLog + "\n"
                  + " Found:\n" + _existingIncidentLog);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ef436edafe036e1621463af086e9f172", "2176563c2170c0b69058cf451a06f6b2");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "instructions","steps","emergency_contacts","medical_profile","incident_log");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `instructions`");
      _db.execSQL("DELETE FROM `steps`");
      _db.execSQL("DELETE FROM `emergency_contacts`");
      _db.execSQL("DELETE FROM `medical_profile`");
      _db.execSQL("DELETE FROM `incident_log`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(InstructionDao.class, InstructionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EmergencyContactDao.class, EmergencyContactDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MedicalProfileDao.class, MedicalProfileDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(IncidentLogDao.class, IncidentLogDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public InstructionDao instructionDao() {
    if (_instructionDao != null) {
      return _instructionDao;
    } else {
      synchronized(this) {
        if(_instructionDao == null) {
          _instructionDao = new InstructionDao_Impl(this);
        }
        return _instructionDao;
      }
    }
  }

  @Override
  public EmergencyContactDao emergencyContactDao() {
    if (_emergencyContactDao != null) {
      return _emergencyContactDao;
    } else {
      synchronized(this) {
        if(_emergencyContactDao == null) {
          _emergencyContactDao = new EmergencyContactDao_Impl(this);
        }
        return _emergencyContactDao;
      }
    }
  }

  @Override
  public MedicalProfileDao medicalProfileDao() {
    if (_medicalProfileDao != null) {
      return _medicalProfileDao;
    } else {
      synchronized(this) {
        if(_medicalProfileDao == null) {
          _medicalProfileDao = new MedicalProfileDao_Impl(this);
        }
        return _medicalProfileDao;
      }
    }
  }

  @Override
  public IncidentLogDao incidentLogDao() {
    if (_incidentLogDao != null) {
      return _incidentLogDao;
    } else {
      synchronized(this) {
        if(_incidentLogDao == null) {
          _incidentLogDao = new IncidentLogDao_Impl(this);
        }
        return _incidentLogDao;
      }
    }
  }
}
