package com.semarescue.android.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.semarescue.android.data.entities.MedicalProfile;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MedicalProfileDao_Impl implements MedicalProfileDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MedicalProfile> __insertionAdapterOfMedicalProfile;

  private final EntityDeletionOrUpdateAdapter<MedicalProfile> __updateAdapterOfMedicalProfile;

  private final SharedSQLiteStatement __preparedStmtOfClearMedicalProfile;

  public MedicalProfileDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMedicalProfile = new EntityInsertionAdapter<MedicalProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `medical_profile` (`id`,`name`,`bloodType`,`allergies`,`medications`,`emergencyNotes`,`isOrganDonor`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MedicalProfile entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getBloodType() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getBloodType());
        }
        if (entity.getAllergies() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAllergies());
        }
        if (entity.getMedications() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getMedications());
        }
        if (entity.getEmergencyNotes() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getEmergencyNotes());
        }
        final int _tmp = entity.isOrganDonor() ? 1 : 0;
        statement.bindLong(7, _tmp);
      }
    };
    this.__updateAdapterOfMedicalProfile = new EntityDeletionOrUpdateAdapter<MedicalProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `medical_profile` SET `id` = ?,`name` = ?,`bloodType` = ?,`allergies` = ?,`medications` = ?,`emergencyNotes` = ?,`isOrganDonor` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MedicalProfile entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getBloodType() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getBloodType());
        }
        if (entity.getAllergies() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAllergies());
        }
        if (entity.getMedications() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getMedications());
        }
        if (entity.getEmergencyNotes() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getEmergencyNotes());
        }
        final int _tmp = entity.isOrganDonor() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getId());
      }
    };
    this.__preparedStmtOfClearMedicalProfile = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM medical_profile";
        return _query;
      }
    };
  }

  @Override
  public Object insertMedicalProfile(final MedicalProfile profile,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMedicalProfile.insert(profile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateMedicalProfile(final MedicalProfile profile,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfMedicalProfile.handle(profile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearMedicalProfile(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearMedicalProfile.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearMedicalProfile.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<MedicalProfile> getMedicalProfile() {
    final String _sql = "SELECT * FROM medical_profile LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"medical_profile"}, new Callable<MedicalProfile>() {
      @Override
      @Nullable
      public MedicalProfile call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfBloodType = CursorUtil.getColumnIndexOrThrow(_cursor, "bloodType");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfMedications = CursorUtil.getColumnIndexOrThrow(_cursor, "medications");
          final int _cursorIndexOfEmergencyNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "emergencyNotes");
          final int _cursorIndexOfIsOrganDonor = CursorUtil.getColumnIndexOrThrow(_cursor, "isOrganDonor");
          final MedicalProfile _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpBloodType;
            if (_cursor.isNull(_cursorIndexOfBloodType)) {
              _tmpBloodType = null;
            } else {
              _tmpBloodType = _cursor.getString(_cursorIndexOfBloodType);
            }
            final String _tmpAllergies;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmpAllergies = null;
            } else {
              _tmpAllergies = _cursor.getString(_cursorIndexOfAllergies);
            }
            final String _tmpMedications;
            if (_cursor.isNull(_cursorIndexOfMedications)) {
              _tmpMedications = null;
            } else {
              _tmpMedications = _cursor.getString(_cursorIndexOfMedications);
            }
            final String _tmpEmergencyNotes;
            if (_cursor.isNull(_cursorIndexOfEmergencyNotes)) {
              _tmpEmergencyNotes = null;
            } else {
              _tmpEmergencyNotes = _cursor.getString(_cursorIndexOfEmergencyNotes);
            }
            final boolean _tmpIsOrganDonor;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsOrganDonor);
            _tmpIsOrganDonor = _tmp != 0;
            _result = new MedicalProfile(_tmpId,_tmpName,_tmpBloodType,_tmpAllergies,_tmpMedications,_tmpEmergencyNotes,_tmpIsOrganDonor);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
